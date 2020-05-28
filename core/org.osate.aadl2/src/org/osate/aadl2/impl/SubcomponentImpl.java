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
import org.eclipse.emf.common.util.ECollections;
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
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentImplementationReference;
import org.osate.aadl2.ComponentPrototype;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Context;
import org.osate.aadl2.EndToEndFlowElement;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FlowElement;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeBinding;
import org.osate.aadl2.Property;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.PrototypeBinding;
import org.osate.aadl2.RefinableElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubcomponentType;
import org.osate.aadl2.operations.ModalElementOperations;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyAcc;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.aadl2.util.NonNotifyingEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subcomponent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.SubcomponentImpl#getInModes <em>In Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubcomponentImpl#getArrayDimensions <em>Array Dimension</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubcomponentImpl#getSubcomponentType <em>Subcomponent Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubcomponentImpl#getRefinedElement <em>Refined Element</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubcomponentImpl#getOwnedPrototypeBindings <em>Owned Prototype Binding</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubcomponentImpl#getPrototype <em>Prototype</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubcomponentImpl#getOwnedModeBindings <em>Owned Mode Binding</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubcomponentImpl#isAllModes <em>All Modes</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubcomponentImpl#getImplementationReferences <em>Implementation Reference</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubcomponentImpl#getRefined <em>Refined</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubcomponentImpl#getClassifier <em>Classifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SubcomponentImpl extends StructuralFeatureImpl implements Subcomponent {
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
	 * The cached value of the '{@link #getOwnedPrototypeBindings() <em>Owned Prototype Binding</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPrototypeBindings()
	 * @generated
	 * @ordered
	 */
	protected EList<PrototypeBinding> ownedPrototypeBindings;

	/**
	 * The cached value of the '{@link #getOwnedModeBindings() <em>Owned Mode Binding</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedModeBindings()
	 * @generated
	 * @ordered
	 */
	protected EList<ModeBinding> ownedModeBindings;

	/**
	 * The default value of the '{@link #isAllModes() <em>All Modes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllModes()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALL_MODES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAllModes() <em>All Modes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllModes()
	 * @generated
	 * @ordered
	 */
	protected boolean allModes = ALL_MODES_EDEFAULT;

	/**
	 * The cached value of the '{@link #getImplementationReferences() <em>Implementation Reference</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementationReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentImplementationReference> implementationReferences;

	/**
	 * The cached value of the '{@link #getRefined() <em>Refined</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefined()
	 * @generated
	 * @ordered
	 */
	protected Subcomponent refined;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubcomponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getSubcomponent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Mode> getInModes() {
		// DONE: implement this method to return the 'In Mode' reference list
		// EList<Mode> inModes = new BasicInternalEList<Mode>(Mode.class);
		// DB This should be an EStructuralFeature.Setting
		EList<Mode> inModes = new NonNotifyingEObjectEList<Mode>(Mode.class, this, Aadl2Package.SUBCOMPONENT__IN_MODE);
		// XXX the resolving EList was notifying the Thread subcomponent of a
		// change to In_Modes
		// which recursively caused the thread subcomponent notify itself
		// new EObjectResolvingEList<Mode>(Mode.class, this,
		// Aadl2Package.SUBCOMPONENT__IN_MODE);

		for (ModeBinding binding : getOwnedModeBindings()) {
			// null test for XText linking service
			if (binding.getParentMode() != null) {
				inModes.add(binding.getParentMode());
			}
		}
		return inModes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInModes() {
		return !getInModes().isEmpty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArrayDimension> getArrayDimensions() {
		if (arrayDimensions == null) {
			arrayDimensions = new EObjectContainmentEList<ArrayDimension>(ArrayDimension.class, this,
					Aadl2Package.SUBCOMPONENT__ARRAY_DIMENSION);
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
	public SubcomponentType getSubcomponentType() {
		SubcomponentType subcomponentType = basicGetSubcomponentType();
		subcomponentType = subcomponentType != null && ((EObject) subcomponentType).eIsProxy()
				? (SubcomponentType) eResolveProxy((InternalEObject) subcomponentType)
				: subcomponentType;
		return subcomponentType == null || subcomponentType.eIsProxy() ? null : subcomponentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SubcomponentType basicGetSubcomponentType() {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ComponentClassifier getClassifier() {
		EObject classifier = getSubcomponentType();
		return (ComponentClassifier) (classifier instanceof ComponentClassifier ? classifier : null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ComponentClassifier basicGetClassifier() {
		// DONE: implement this method to return the 'Classifier' reference
		SubcomponentType st = basicGetSubcomponentType();
		if (st instanceof ComponentClassifier) {
			return (ComponentClassifier) st;
		}

		return st instanceof ComponentClassifier ? (ComponentClassifier) st : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PrototypeBinding> getOwnedPrototypeBindings() {
		if (ownedPrototypeBindings == null) {
			ownedPrototypeBindings = new EObjectContainmentEList<PrototypeBinding>(PrototypeBinding.class, this,
					Aadl2Package.SUBCOMPONENT__OWNED_PROTOTYPE_BINDING);
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
	 * @generated NOT
	 */
	public ComponentPrototype getPrototype() {
		EObject prototype = getSubcomponentType();
		return (ComponentPrototype) (prototype instanceof ComponentPrototype ? prototype : null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ComponentPrototype basicGetPrototype() {
		// DONE: implement this method to return the 'Prototype' reference
		SubcomponentType st = basicGetSubcomponentType();

		return st instanceof ComponentPrototype ? (ComponentPrototype) st : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModeBinding> getOwnedModeBindings() {
		if (ownedModeBindings == null) {
			ownedModeBindings = new EObjectContainmentEList<ModeBinding>(ModeBinding.class, this,
					Aadl2Package.SUBCOMPONENT__OWNED_MODE_BINDING);
		}
		return ownedModeBindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModeBinding createOwnedModeBinding() {
		ModeBinding newOwnedModeBinding = (ModeBinding) create(Aadl2Package.eINSTANCE.getModeBinding());
		getOwnedModeBindings().add(newOwnedModeBinding);
		return newOwnedModeBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllModes() {
		return allModes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllModes(boolean newAllModes) {
		boolean oldAllModes = allModes;
		allModes = newAllModes;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.SUBCOMPONENT__ALL_MODES, oldAllModes,
					allModes));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentImplementationReference> getImplementationReferences() {
		if (implementationReferences == null) {
			implementationReferences = new EObjectContainmentEList<ComponentImplementationReference>(
					ComponentImplementationReference.class, this, Aadl2Package.SUBCOMPONENT__IMPLEMENTATION_REFERENCE);
		}
		return implementationReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentImplementationReference createImplementationReference() {
		ComponentImplementationReference newImplementationReference = (ComponentImplementationReference) create(
				Aadl2Package.eINSTANCE.getComponentImplementationReference());
		getImplementationReferences().add(newImplementationReference);
		return newImplementationReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subcomponent getRefined() {
		if (refined != null && ((EObject) refined).eIsProxy()) {
			InternalEObject oldRefined = (InternalEObject) refined;
			refined = (Subcomponent) eResolveProxy(oldRefined);
			if (refined != oldRefined) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Aadl2Package.SUBCOMPONENT__REFINED,
							oldRefined, refined));
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
	public Subcomponent basicGetRefined() {
		return refined;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setRefined(Subcomponent newRefined) {
		Subcomponent oldRefined = refined;
		refined = newRefined;

		// DB: Avoid having a non null name to refined elements (causes a validation error during serialization
		// when both the name and refined element are set).
		if (refined != null) {
			setName(null);
		}

		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.SUBCOMPONENT__REFINED, oldRefined,
					refined));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mode> getAllInModes() {
		return ModalElementOperations.getAllInModes(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.SUBCOMPONENT__ARRAY_DIMENSION:
			return ((InternalEList<?>) getArrayDimensions()).basicRemove(otherEnd, msgs);
		case Aadl2Package.SUBCOMPONENT__OWNED_PROTOTYPE_BINDING:
			return ((InternalEList<?>) getOwnedPrototypeBindings()).basicRemove(otherEnd, msgs);
		case Aadl2Package.SUBCOMPONENT__OWNED_MODE_BINDING:
			return ((InternalEList<?>) getOwnedModeBindings()).basicRemove(otherEnd, msgs);
		case Aadl2Package.SUBCOMPONENT__IMPLEMENTATION_REFERENCE:
			return ((InternalEList<?>) getImplementationReferences()).basicRemove(otherEnd, msgs);
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
		case Aadl2Package.SUBCOMPONENT__IN_MODE:
			return getInModes();
		case Aadl2Package.SUBCOMPONENT__ARRAY_DIMENSION:
			return getArrayDimensions();
		case Aadl2Package.SUBCOMPONENT__SUBCOMPONENT_TYPE:
			if (resolve) {
				return getSubcomponentType();
			}
			return basicGetSubcomponentType();
		case Aadl2Package.SUBCOMPONENT__OWNED_PROTOTYPE_BINDING:
			return getOwnedPrototypeBindings();
		case Aadl2Package.SUBCOMPONENT__PROTOTYPE:
			if (resolve) {
				return getPrototype();
			}
			return basicGetPrototype();
		case Aadl2Package.SUBCOMPONENT__OWNED_MODE_BINDING:
			return getOwnedModeBindings();
		case Aadl2Package.SUBCOMPONENT__ALL_MODES:
			return isAllModes();
		case Aadl2Package.SUBCOMPONENT__IMPLEMENTATION_REFERENCE:
			return getImplementationReferences();
		case Aadl2Package.SUBCOMPONENT__REFINED:
			if (resolve) {
				return getRefined();
			}
			return basicGetRefined();
		case Aadl2Package.SUBCOMPONENT__CLASSIFIER:
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
		case Aadl2Package.SUBCOMPONENT__IN_MODE:
			getInModes().clear();
			getInModes().addAll((Collection<? extends Mode>) newValue);
			return;
		case Aadl2Package.SUBCOMPONENT__ARRAY_DIMENSION:
			getArrayDimensions().clear();
			getArrayDimensions().addAll((Collection<? extends ArrayDimension>) newValue);
			return;
		case Aadl2Package.SUBCOMPONENT__OWNED_PROTOTYPE_BINDING:
			getOwnedPrototypeBindings().clear();
			getOwnedPrototypeBindings().addAll((Collection<? extends PrototypeBinding>) newValue);
			return;
		case Aadl2Package.SUBCOMPONENT__OWNED_MODE_BINDING:
			getOwnedModeBindings().clear();
			getOwnedModeBindings().addAll((Collection<? extends ModeBinding>) newValue);
			return;
		case Aadl2Package.SUBCOMPONENT__ALL_MODES:
			setAllModes((Boolean) newValue);
			return;
		case Aadl2Package.SUBCOMPONENT__IMPLEMENTATION_REFERENCE:
			getImplementationReferences().clear();
			getImplementationReferences().addAll((Collection<? extends ComponentImplementationReference>) newValue);
			return;
		case Aadl2Package.SUBCOMPONENT__REFINED:
			setRefined((Subcomponent) newValue);
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
		case Aadl2Package.SUBCOMPONENT__IN_MODE:
			getInModes().clear();
			return;
		case Aadl2Package.SUBCOMPONENT__ARRAY_DIMENSION:
			getArrayDimensions().clear();
			return;
		case Aadl2Package.SUBCOMPONENT__OWNED_PROTOTYPE_BINDING:
			getOwnedPrototypeBindings().clear();
			return;
		case Aadl2Package.SUBCOMPONENT__OWNED_MODE_BINDING:
			getOwnedModeBindings().clear();
			return;
		case Aadl2Package.SUBCOMPONENT__ALL_MODES:
			setAllModes(ALL_MODES_EDEFAULT);
			return;
		case Aadl2Package.SUBCOMPONENT__IMPLEMENTATION_REFERENCE:
			getImplementationReferences().clear();
			return;
		case Aadl2Package.SUBCOMPONENT__REFINED:
			setRefined((Subcomponent) null);
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
		case Aadl2Package.SUBCOMPONENT__IN_MODE:
			return isSetInModes();
		case Aadl2Package.SUBCOMPONENT__ARRAY_DIMENSION:
			return arrayDimensions != null && !arrayDimensions.isEmpty();
		case Aadl2Package.SUBCOMPONENT__SUBCOMPONENT_TYPE:
			return isSetSubcomponentType();
		case Aadl2Package.SUBCOMPONENT__REFINED_ELEMENT:
			return isSetRefinedElement();
		case Aadl2Package.SUBCOMPONENT__OWNED_PROTOTYPE_BINDING:
			return ownedPrototypeBindings != null && !ownedPrototypeBindings.isEmpty();
		case Aadl2Package.SUBCOMPONENT__PROTOTYPE:
			return basicGetPrototype() != null;
		case Aadl2Package.SUBCOMPONENT__OWNED_MODE_BINDING:
			return ownedModeBindings != null && !ownedModeBindings.isEmpty();
		case Aadl2Package.SUBCOMPONENT__ALL_MODES:
			return allModes != ALL_MODES_EDEFAULT;
		case Aadl2Package.SUBCOMPONENT__IMPLEMENTATION_REFERENCE:
			return implementationReferences != null && !implementationReferences.isEmpty();
		case Aadl2Package.SUBCOMPONENT__REFINED:
			return refined != null;
		case Aadl2Package.SUBCOMPONENT__CLASSIFIER:
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
		if (baseClass == ModalElement.class) {
			switch (derivedFeatureID) {
			case Aadl2Package.SUBCOMPONENT__IN_MODE:
				return Aadl2Package.MODAL_ELEMENT__IN_MODE;
			default:
				return -1;
			}
		}
		if (baseClass == Context.class) {
			switch (derivedFeatureID) {
			default:
				return -1;
			}
		}
		if (baseClass == EndToEndFlowElement.class) {
			switch (derivedFeatureID) {
			default:
				return -1;
			}
		}
		if (baseClass == FlowElement.class) {
			switch (derivedFeatureID) {
			default:
				return -1;
			}
		}
		if (baseClass == ArrayableElement.class) {
			switch (derivedFeatureID) {
			case Aadl2Package.SUBCOMPONENT__ARRAY_DIMENSION:
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
		if (baseClass == ModalElement.class) {
			switch (baseFeatureID) {
			case Aadl2Package.MODAL_ELEMENT__IN_MODE:
				return Aadl2Package.SUBCOMPONENT__IN_MODE;
			default:
				return -1;
			}
		}
		if (baseClass == Context.class) {
			switch (baseFeatureID) {
			default:
				return -1;
			}
		}
		if (baseClass == EndToEndFlowElement.class) {
			switch (baseFeatureID) {
			default:
				return -1;
			}
		}
		if (baseClass == FlowElement.class) {
			switch (baseFeatureID) {
			default:
				return -1;
			}
		}
		if (baseClass == ArrayableElement.class) {
			switch (baseFeatureID) {
			case Aadl2Package.ARRAYABLE_ELEMENT__ARRAY_DIMENSION:
				return Aadl2Package.SUBCOMPONENT__ARRAY_DIMENSION;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (allModes: ");
		result.append(allModes);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSubcomponentType() {
		return eIsSet(Aadl2Package.SUBCOMPONENT__PROTOTYPE) || eIsSet(Aadl2Package.SUBCOMPONENT__CLASSIFIER);
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
		if (eIsSet(Aadl2Package.SUBCOMPONENT__REFINED)) {
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
		return super.isSetRefinedElement() || eIsSet(Aadl2Package.SUBCOMPONENT__REFINED);
	}

	/**
	 * returns the component implementation object of a given subcomponent
	 * @return Component implementation
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation and property lookup
	// work.
	public ComponentImplementation getComponentImplementation() {
		ComponentClassifier cc = getClassifier();
		if (Aadl2Util.isNull(cc)) {
			return null;
		}
		if (cc instanceof ComponentImplementation) {
			return (ComponentImplementation) cc;
		}
		return null;
	}

	/**
	 * returns the component type object of a given subcomponent
	 * @return Component type
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	public ComponentType getComponentType() {
		ComponentClassifier cc = getClassifier();
		if (Aadl2Util.isNull(cc)) {
			return null;
		}
		if (cc instanceof ComponentImplementation) {
			ComponentType ct = ((ComponentImplementation) cc).getType();
			return Aadl2Util.isNull(ct) ? null : ct;
		}
		if (cc instanceof ComponentType) {
			return (ComponentType) cc;
		}
		return null;
	}

	/**
	 * Return the subcomponent and any of the subcomponents it refines
	 * @return EList of subcomponent
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation and property lookup
	// work.
	public EList<Subcomponent> getAllSubcomponentRefinements() {
		BasicEList<Subcomponent> returnlist = new BasicEList<Subcomponent>();
		Subcomponent more = this;
		while (!Aadl2Util.isNull(more)) {
			returnlist.add(more);
			more = more.getRefined();
		}
		return returnlist;
	}

	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	public ComponentClassifier getAllClassifier() {
		ComponentClassifier cc = getClassifier();
		Subcomponent sub = this;
		while (Aadl2Util.isNull(cc) && !Aadl2Util.isNull(sub.getRefined())) {
			sub = sub.getRefined();
			cc = sub.getClassifier();
		}
		return Aadl2Util.isNull(cc) ? null : cc;
	}

	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	@Override
	public boolean acceptsProperty(Property property) {
		if (super.acceptsProperty(property)) {
			return true;
		} else if (getClassifier() != null) {
			return getClassifier().checkAppliesToClassifier(property);
		} else {
			return false;
		}
	}

	// TODO-lw: Why don't we return immediately if a pa was found?
	@Override
	public final void getPropertyValueInternal(final Property prop, final PropertyAcc pas,
			final boolean fromInstanceSlaveCall, final boolean all) throws InvalidModelException {
		final ComponentImplementation owner = (ComponentImplementation) getContainingClassifier();

		// local contained value
		if (!fromInstanceSlaveCall) {
			pas.addLocalContained(this, owner);
		}

		// get local value
		pas.addLocal(this);

		// collect values from refined subcomponents
		Subcomponent refined = getRefined();
		while (refined != null) {
			if (!fromInstanceSlaveCall) {
				pas.addLocalContained(refined, refined.getContainingClassifier());
			}
			pas.addLocal(refined);
			refined = refined.getRefined();
		}

		// get values from classifier
		final ComponentClassifier cc = getClassifier();
		if (cc != null) {
			cc.getPropertyValueInternal(prop, pas, fromInstanceSlaveCall, all);
		}

		// get values from container
		if (!fromInstanceSlaveCall && prop.isInherit()) {
			owner.getPropertyValueInternal(prop, pas, fromInstanceSlaveCall, all);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.osate.aadl2.Subcomponent#getPrototypeActual(org.osate.aadl2.Prototype
	 * )
	 */
	public PrototypeBinding lookupPrototypeBinding(Prototype proto) {
		for (PrototypeBinding pb : getOwnedPrototypeBindings()) {
			if (pb.getFormal() == proto) {
				return pb;
			}
		}
		if (getRefined() != null) {
			return getRefined().lookupPrototypeBinding(proto);
		}
		return null;
	}

	public void getPropertyValue(Property prop, PropertyAcc pas, Classifier cl, final boolean all) {
		final ComponentImplementation owner = (ComponentImplementation) getContainingClassifier();

		if (pas.addLocalContained(this, owner)) {
			return;
		}

		// get local value
		if (pas.addLocal(this)) {
			return;
		}

		// collect values from refined subcomponents
		Subcomponent refined = getRefined();
		while (refined != null) {
			if (pas.addLocal(refined)) {
				return;
			}
			refined = refined.getRefined();
		}

		// get values from classifier
		if (cl != null) {
			cl.getPropertyValueInternal(prop, pas, true, all);
		} else {
			final ComponentClassifier cc = getClassifier();
			if (cc != null) {
				cc.getPropertyValueInternal(prop, pas, true, all);
			}
		}
	}

	/**
	 * Get list of all features of a subcomponent, including ancestor features
	 * These are the features of its classifier
	 * In case of refined features the refined feature is returned in the list.
	 * @return List of features
	 */
	public EList<Feature> getAllFeatures() {
		ComponentImplementation ci = getComponentImplementation();
		if (ci != null) {
			return ci.getAllFeatures();
		}
		ComponentType ct = getComponentType();
		if (ct != null) {
			return ct.getAllFeatures();
		}
		return ECollections.emptyEList();
	}

} // SubcomponentImpl
