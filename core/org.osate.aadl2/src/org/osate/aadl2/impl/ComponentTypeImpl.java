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
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;

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
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierFeature;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.TypeExtension;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyAcc;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.ComponentTypeImpl#getOwnedFeatures <em>Owned Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentTypeImpl#getClassifierFeatures <em>Classifier Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentTypeImpl#getOwnedMembers <em>Owned Member</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentTypeImpl#getGenerals <em>General</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentTypeImpl#getGeneralizations <em>Generalization</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentTypeImpl#getExtended <em>Extended</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentTypeImpl#getOwnedFlowSpecifications <em>Owned Flow Specification</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentTypeImpl#getOwnedExtension <em>Owned Extension</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentTypeImpl#getOwnedFeatureGroups <em>Owned Feature Group</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentTypeImpl#getOwnedAbstractFeatures <em>Owned Abstract Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentTypeImpl#isNoFeatures <em>No Features</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ComponentTypeImpl extends ComponentClassifierImpl implements ComponentType {
	/**
	 * The cached value of the '{@link #getOwnedFlowSpecifications() <em>Owned Flow Specification</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedFlowSpecifications()
	 * @generated
	 * @ordered
	 */
	protected EList<FlowSpecification> ownedFlowSpecifications;
	/**
	 * The cached value of the '{@link #getOwnedExtension() <em>Owned Extension</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedExtension()
	 * @generated
	 * @ordered
	 */
	protected TypeExtension ownedExtension;

	/**
	 * The cached value of the '{@link #getOwnedFeatureGroups() <em>Owned Feature Group</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedFeatureGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureGroup> ownedFeatureGroups;

	/**
	 * The cached value of the '{@link #getOwnedAbstractFeatures() <em>Owned Abstract Feature</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedAbstractFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractFeature> ownedAbstractFeatures;

	/**
	 * The default value of the '{@link #isNoFeatures() <em>No Features</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoFeatures()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NO_FEATURES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNoFeatures() <em>No Features</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoFeatures()
	 * @generated
	 * @ordered
	 */
	protected boolean noFeatures = NO_FEATURES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getComponentType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getOwnedFeatures() {
		return new DerivedUnionEObjectEList<Feature>(Feature.class, this, Aadl2Package.COMPONENT_TYPE__OWNED_FEATURE,
				OWNED_FEATURE_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedFeatures() <em>Owned Feature</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedFeatures()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_FEATURE_ESUBSETS = new int[] { Aadl2Package.COMPONENT_TYPE__OWNED_FEATURE_GROUP,
			Aadl2Package.COMPONENT_TYPE__OWNED_ABSTRACT_FEATURE };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassifierFeature> getClassifierFeatures() {
		return new DerivedUnionEObjectEList<ClassifierFeature>(ClassifierFeature.class, this,
				Aadl2Package.COMPONENT_TYPE__CLASSIFIER_FEATURE, CLASSIFIER_FEATURE_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getClassifierFeatures() <em>Classifier Feature</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassifierFeatures()
	 * @generated
	 * @ordered
	 */
	protected static final int[] CLASSIFIER_FEATURE_ESUBSETS = new int[] { Aadl2Package.COMPONENT_TYPE__OWNED_MODE,
			Aadl2Package.COMPONENT_TYPE__OWNED_MODE_TRANSITION, Aadl2Package.COMPONENT_TYPE__OWNED_FEATURE,
			Aadl2Package.COMPONENT_TYPE__OWNED_FLOW_SPECIFICATION };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedElement> getOwnedMembers() {
		return new DerivedUnionEObjectEList<NamedElement>(NamedElement.class, this,
				Aadl2Package.COMPONENT_TYPE__OWNED_MEMBER, OWNED_MEMBER_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedMembers() <em>Owned Member</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMembers()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_MEMBER_ESUBSETS = new int[] { Aadl2Package.COMPONENT_TYPE__OWNED_ANNEX_SUBCLAUSE,
			Aadl2Package.COMPONENT_TYPE__OWNED_PROTOTYPE, Aadl2Package.COMPONENT_TYPE__OWNED_MODE,
			Aadl2Package.COMPONENT_TYPE__OWNED_MODE_TRANSITION, Aadl2Package.COMPONENT_TYPE__OWNED_FEATURE,
			Aadl2Package.COMPONENT_TYPE__OWNED_FLOW_SPECIFICATION };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Classifier> getGenerals() {
		return new DerivedUnionEObjectEList<Classifier>(Classifier.class, this, Aadl2Package.COMPONENT_TYPE__GENERAL,
				GENERAL_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getGenerals() <em>General</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerals()
	 * @generated
	 * @ordered
	 */
	protected static final int[] GENERAL_ESUBSETS = new int[] { Aadl2Package.COMPONENT_TYPE__EXTENDED };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Generalization> getGeneralizations() {
		return new DerivedUnionEObjectEList<Generalization>(Generalization.class, this,
				Aadl2Package.COMPONENT_TYPE__GENERALIZATION, GENERALIZATION_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getGeneralizations() <em>Generalization</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralizations()
	 * @generated
	 * @ordered
	 */
	protected static final int[] GENERALIZATION_ESUBSETS = new int[] { Aadl2Package.COMPONENT_TYPE__OWNED_EXTENSION };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNoFeatures() {
		return noFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNoFeatures(boolean newNoFeatures) {
		boolean oldNoFeatures = noFeatures;
		noFeatures = newNoFeatures;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.COMPONENT_TYPE__NO_FEATURES,
					oldNoFeatures, noFeatures));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentType getExtended() {
		ComponentType extended = basicGetExtended();
		return extended != null && ((EObject) extended).eIsProxy()
				? (ComponentType) eResolveProxy((InternalEObject) extended)
				: extended;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ComponentType basicGetExtended() {
		// DONE: implement this method to return the 'Extended' reference
		if (getOwnedExtension() == null) {
			return null;
		}
		return ((TypeExtensionImpl) getOwnedExtension()).basicGetExtended();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setExtended(ComponentType newExtended) {
		if (newExtended == null) {
			setOwnedExtension(null);
		} else {
			if (getOwnedExtension() == null) {
				createOwnedExtension();
			}

			getOwnedExtension().setExtended(newExtended);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FlowSpecification> getOwnedFlowSpecifications() {
		if (ownedFlowSpecifications == null) {
			ownedFlowSpecifications = new EObjectContainmentEList<FlowSpecification>(FlowSpecification.class, this,
					Aadl2Package.COMPONENT_TYPE__OWNED_FLOW_SPECIFICATION);
		}
		return ownedFlowSpecifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowSpecification createOwnedFlowSpecification() {
		FlowSpecification newOwnedFlowSpecification = (FlowSpecification) create(
				Aadl2Package.eINSTANCE.getFlowSpecification());
		getOwnedFlowSpecifications().add(newOwnedFlowSpecification);
		return newOwnedFlowSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeExtension getOwnedExtension() {
		return ownedExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedExtension(TypeExtension newOwnedExtension, NotificationChain msgs) {
		TypeExtension oldOwnedExtension = ownedExtension;
		ownedExtension = newOwnedExtension;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.COMPONENT_TYPE__OWNED_EXTENSION, oldOwnedExtension, newOwnedExtension);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedExtension(TypeExtension newOwnedExtension) {
		if (newOwnedExtension != ownedExtension) {
			NotificationChain msgs = null;
			if (ownedExtension != null)
				msgs = ((InternalEObject) ownedExtension).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.COMPONENT_TYPE__OWNED_EXTENSION, null, msgs);
			if (newOwnedExtension != null)
				msgs = ((InternalEObject) newOwnedExtension).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.COMPONENT_TYPE__OWNED_EXTENSION, null, msgs);
			msgs = basicSetOwnedExtension(newOwnedExtension, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.COMPONENT_TYPE__OWNED_EXTENSION,
					newOwnedExtension, newOwnedExtension));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeExtension createOwnedExtension() {
		TypeExtension newOwnedExtension = (TypeExtension) create(Aadl2Package.eINSTANCE.getTypeExtension());
		setOwnedExtension(newOwnedExtension);
		return newOwnedExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FeatureGroup> getOwnedFeatureGroups() {
		if (ownedFeatureGroups == null) {
			ownedFeatureGroups = new EObjectContainmentEList<FeatureGroup>(FeatureGroup.class, this,
					Aadl2Package.COMPONENT_TYPE__OWNED_FEATURE_GROUP);
		}
		return ownedFeatureGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureGroup createOwnedFeatureGroup() {
		FeatureGroup newOwnedFeatureGroup = (FeatureGroup) create(Aadl2Package.eINSTANCE.getFeatureGroup());
		getOwnedFeatureGroups().add(newOwnedFeatureGroup);
		return newOwnedFeatureGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractFeature> getOwnedAbstractFeatures() {
		if (ownedAbstractFeatures == null) {
			ownedAbstractFeatures = new EObjectContainmentEList<AbstractFeature>(AbstractFeature.class, this,
					Aadl2Package.COMPONENT_TYPE__OWNED_ABSTRACT_FEATURE);
		}
		return ownedAbstractFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractFeature createOwnedAbstractFeature() {
		AbstractFeature newOwnedAbstractFeature = (AbstractFeature) create(Aadl2Package.eINSTANCE.getAbstractFeature());
		getOwnedAbstractFeatures().add(newOwnedAbstractFeature);
		return newOwnedAbstractFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.COMPONENT_TYPE__OWNED_FLOW_SPECIFICATION:
			return ((InternalEList<?>) getOwnedFlowSpecifications()).basicRemove(otherEnd, msgs);
		case Aadl2Package.COMPONENT_TYPE__OWNED_EXTENSION:
			return basicSetOwnedExtension(null, msgs);
		case Aadl2Package.COMPONENT_TYPE__OWNED_FEATURE_GROUP:
			return ((InternalEList<?>) getOwnedFeatureGroups()).basicRemove(otherEnd, msgs);
		case Aadl2Package.COMPONENT_TYPE__OWNED_ABSTRACT_FEATURE:
			return ((InternalEList<?>) getOwnedAbstractFeatures()).basicRemove(otherEnd, msgs);
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
		case Aadl2Package.COMPONENT_TYPE__OWNED_FEATURE:
			return getOwnedFeatures();
		case Aadl2Package.COMPONENT_TYPE__EXTENDED:
			if (resolve)
				return getExtended();
			return basicGetExtended();
		case Aadl2Package.COMPONENT_TYPE__OWNED_FLOW_SPECIFICATION:
			return getOwnedFlowSpecifications();
		case Aadl2Package.COMPONENT_TYPE__OWNED_EXTENSION:
			return getOwnedExtension();
		case Aadl2Package.COMPONENT_TYPE__OWNED_FEATURE_GROUP:
			return getOwnedFeatureGroups();
		case Aadl2Package.COMPONENT_TYPE__OWNED_ABSTRACT_FEATURE:
			return getOwnedAbstractFeatures();
		case Aadl2Package.COMPONENT_TYPE__NO_FEATURES:
			return isNoFeatures();
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
		case Aadl2Package.COMPONENT_TYPE__EXTENDED:
			setExtended((ComponentType) newValue);
			return;
		case Aadl2Package.COMPONENT_TYPE__OWNED_FLOW_SPECIFICATION:
			getOwnedFlowSpecifications().clear();
			getOwnedFlowSpecifications().addAll((Collection<? extends FlowSpecification>) newValue);
			return;
		case Aadl2Package.COMPONENT_TYPE__OWNED_EXTENSION:
			setOwnedExtension((TypeExtension) newValue);
			return;
		case Aadl2Package.COMPONENT_TYPE__OWNED_FEATURE_GROUP:
			getOwnedFeatureGroups().clear();
			getOwnedFeatureGroups().addAll((Collection<? extends FeatureGroup>) newValue);
			return;
		case Aadl2Package.COMPONENT_TYPE__OWNED_ABSTRACT_FEATURE:
			getOwnedAbstractFeatures().clear();
			getOwnedAbstractFeatures().addAll((Collection<? extends AbstractFeature>) newValue);
			return;
		case Aadl2Package.COMPONENT_TYPE__NO_FEATURES:
			setNoFeatures((Boolean) newValue);
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
		case Aadl2Package.COMPONENT_TYPE__EXTENDED:
			setExtended((ComponentType) null);
			return;
		case Aadl2Package.COMPONENT_TYPE__OWNED_FLOW_SPECIFICATION:
			getOwnedFlowSpecifications().clear();
			return;
		case Aadl2Package.COMPONENT_TYPE__OWNED_EXTENSION:
			setOwnedExtension((TypeExtension) null);
			return;
		case Aadl2Package.COMPONENT_TYPE__OWNED_FEATURE_GROUP:
			getOwnedFeatureGroups().clear();
			return;
		case Aadl2Package.COMPONENT_TYPE__OWNED_ABSTRACT_FEATURE:
			getOwnedAbstractFeatures().clear();
			return;
		case Aadl2Package.COMPONENT_TYPE__NO_FEATURES:
			setNoFeatures(NO_FEATURES_EDEFAULT);
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
		case Aadl2Package.COMPONENT_TYPE__OWNED_FEATURE:
			return isSetOwnedFeatures();
		case Aadl2Package.COMPONENT_TYPE__CLASSIFIER_FEATURE:
			return isSetClassifierFeatures();
		case Aadl2Package.COMPONENT_TYPE__OWNED_MEMBER:
			return isSetOwnedMembers();
		case Aadl2Package.COMPONENT_TYPE__GENERAL:
			return isSetGenerals();
		case Aadl2Package.COMPONENT_TYPE__GENERALIZATION:
			return isSetGeneralizations();
		case Aadl2Package.COMPONENT_TYPE__EXTENDED:
			return basicGetExtended() != null;
		case Aadl2Package.COMPONENT_TYPE__OWNED_FLOW_SPECIFICATION:
			return ownedFlowSpecifications != null && !ownedFlowSpecifications.isEmpty();
		case Aadl2Package.COMPONENT_TYPE__OWNED_EXTENSION:
			return ownedExtension != null;
		case Aadl2Package.COMPONENT_TYPE__OWNED_FEATURE_GROUP:
			return ownedFeatureGroups != null && !ownedFeatureGroups.isEmpty();
		case Aadl2Package.COMPONENT_TYPE__OWNED_ABSTRACT_FEATURE:
			return ownedAbstractFeatures != null && !ownedAbstractFeatures.isEmpty();
		case Aadl2Package.COMPONENT_TYPE__NO_FEATURES:
			return noFeatures != NO_FEATURES_EDEFAULT;
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
		result.append(" (noFeatures: ");
		result.append(noFeatures);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedFeatures() {
		return eIsSet(Aadl2Package.COMPONENT_TYPE__OWNED_FEATURE_GROUP)
				|| eIsSet(Aadl2Package.COMPONENT_TYPE__OWNED_ABSTRACT_FEATURE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetClassifierFeatures() {
		return super.isSetClassifierFeatures() || isSetOwnedFeatures()
				|| eIsSet(Aadl2Package.COMPONENT_TYPE__OWNED_FLOW_SPECIFICATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedMembers() {
		return super.isSetOwnedMembers() || isSetOwnedFeatures()
				|| eIsSet(Aadl2Package.COMPONENT_TYPE__OWNED_FLOW_SPECIFICATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetGenerals() {
		return super.isSetGenerals() || eIsSet(Aadl2Package.COMPONENT_TYPE__EXTENDED);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetGeneralizations() {
		return super.isSetGeneralizations() || eIsSet(Aadl2Package.COMPONENT_TYPE__OWNED_EXTENSION);
	}

	/**
	 * get list of all features of a component type, including ancestor features
	 * In case of refined features the refined feature is returned.
	 *
	 * @return List of feature objects
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	public EList<Feature> getAllFeatures() {
		final EList<Classifier> ancestors = getSelfPlusAllExtended();
		final BasicEList<Feature> returnlist = new BasicEList<Feature>();
		// Process from farthest ancestor to self
		for (ListIterator<Classifier> li = ancestors.listIterator(ancestors.size()); li.hasPrevious();) {
			final ComponentType current = (ComponentType) li.previous();
			final EList<Feature> currentFeatures = current.getOwnedFeatures();
			if (currentFeatures != null) {
				for (Iterator<Feature> i = currentFeatures.iterator(); i.hasNext();) {
					final Feature fe = i.next();
					final Feature rfe = fe.getRefined();
					if (rfe != null) {
						returnlist.remove(rfe);
					}
					returnlist.add(fe);
				}
			}
		}
		return returnlist;
	}

	/**
	 * get list of all flow specs of a component type, including ancestor
	 * features In case of refined flow specs the refined flow spec is returned
	 * in the list.
	 *
	 * @return List of flow specs
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	public EList<FlowSpecification> getAllFlowSpecifications() {
		final EList<Classifier> ancestors = getSelfPlusAllExtended();
		final BasicEList<FlowSpecification> returnlist = new BasicEList<FlowSpecification>();
		// Process from farthest ancestor to self
		for (ListIterator<Classifier> li = ancestors.listIterator(ancestors.size()); li.hasPrevious();) {
			final ComponentType current = (ComponentType) li.previous();
			final EList<FlowSpecification> currentItems = current.getOwnedFlowSpecifications();
			if (currentItems != null) {
				for (Iterator<FlowSpecification> i = currentItems.iterator(); i.hasNext();) {
					final FlowSpecification fe = i.next();
					final FlowSpecification rfe = fe.getRefined();
					if (rfe != null) {
						returnlist.remove(rfe);
					}
					returnlist.add(fe);
				}
			}
		}
		return returnlist;
	}

	/**
	 * Returns all the mode objects of a given type, including
	 * ancestor.
	 *
	 * @return EList of all mode objects
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation and property lookup
	// work.
	// public EList<Mode> getAllModes() {
	// EList<Classifier> ancestors = getSelfPlusAllExtended();
	// final BasicEList<Mode> returnlist = new BasicEList<Mode>();
	// for (Iterator<Classifier> it = ancestors.iterator(); it.hasNext();) {
	// final ComponentType current = (ComponentType) it.next();
	// returnlist.addAll(current.getOwnedModes());
	// }
	// return returnlist;
	// }
	public EList<Mode> getAllModes() {
		EList<Classifier> ancestors = getSelfPlusAllExtended();
		final BasicEList<Mode> returnlist = new BasicEList<Mode>();
		for (ListIterator<Classifier> it = ancestors.listIterator(ancestors.size()); it.hasPrevious();) {
			final ComponentType current = (ComponentType) it.previous();
			returnlist.addAll(current.getOwnedModes());
		}
		return returnlist;
	}

	/**
	 * Returns all the mode transition objects of a given type,
	 * including ancestor.
	 *
	 * @return EList of all mode transition objects
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	public EList<ModeTransition> getAllModeTransitions() {
		EList<Classifier> ancestors = getSelfPlusAllExtended();
		final BasicEList<ModeTransition> returnlist = new BasicEList<ModeTransition>();
		for (Iterator<Classifier> it = ancestors.iterator(); it.hasNext();) {
			final ComponentType current = (ComponentType) it.next();
			returnlist.addAll(current.getOwnedModeTransitions());
		}
		return returnlist;
	}

	/**
	 * Returns all the prototype objects of a given type, including
	 * ancestor.
	 *
	 * @return EList of all mode objects
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation and property lookup
	// work.
	public EList<Prototype> getAllPrototypes() {
		EList<Classifier> ancestors = getSelfPlusAllExtended();
		final BasicEList<Prototype> returnlist = new BasicEList<Prototype>();
		// Process from farthest ancestor to self
		for (ListIterator<Classifier> li = ancestors.listIterator(ancestors.size()); li.hasPrevious();) {
			final ComponentType current = (ComponentType) li.previous();
			final EList<Prototype> currentItems = current.getOwnedPrototypes();
			if (currentItems != null) {
				for (Iterator<Prototype> i = currentItems.iterator(); i.hasNext();) {
					final Prototype fe = i.next();
					final Prototype rfe = fe.getRefined();
					if (rfe != null) {
						returnlist.remove(rfe);
					}
					returnlist.add(fe);
				}
			}
		}
		return returnlist;
	}

	/**
	 * Does this component type descend from the given classifier? A
	 * component type descends from another component type if they are the same
	 * type, it extends the other type, or it extends a descendant of the other
	 * type. A component type never descends from a component implementation.
	 *
	 * @return Whether this classifier descends from the given classifier.
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	public final boolean isDescendentOf(Classifier c) {
		ComponentType current = this;
		do {
			if (current == c) {
				return true;
			}
			current = current.getExtended();
			// avoid loops by stopping if we extend ourself
		} while (current != null && current != this);
		return false;
	}

	public final void getPropertyValueInternal(final Property property, final PropertyAcc paa,
			final boolean fromInstanceSlaveCall, final boolean all) throws InvalidModelException {
		/*
		 * First see if the property is defined in component's properties
		 * subclause (could merge this with the loop below, but I want to make
		 * the steps more explicit.)
		 */
		if (paa.addLocal(this)) {
			if (!all) {
				return;
			}
		}

		// Next walk the component type hierarchy
		// Avoid loops by stopping if we extend ourself
		final Set<ComponentType> seen = new HashSet<ComponentType>();
		ComponentType currentType = getExtended();
		while (currentType != null && !seen.contains(currentType)) {
			if (paa.addLocal(currentType)) {
				if (!all) {
					return;
				}
			}
			seen.add(currentType);
			currentType = currentType.getExtended();
		}
	}

} // ComponentTypeImpl
