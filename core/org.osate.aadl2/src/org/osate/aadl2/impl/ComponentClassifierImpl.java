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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ClassifierFeature;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NamedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Classifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.ComponentClassifierImpl#getClassifierFeatures <em>Classifier Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentClassifierImpl#getOwnedMembers <em>Owned Member</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentClassifierImpl#getOwnedModes <em>Owned Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentClassifierImpl#getOwnedModeTransitions <em>Owned Mode Transition</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentClassifierImpl#isDerivedModes <em>Derived Modes</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentClassifierImpl#isNoFlows <em>No Flows</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentClassifierImpl#isNoModes <em>No Modes</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ComponentClassifierImpl extends ClassifierImpl implements ComponentClassifier {
	/**
	 * The cached value of the '{@link #getOwnedModes() <em>Owned Mode</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedModes()
	 * @generated
	 * @ordered
	 */
	protected EList<Mode> ownedModes;
	/**
	 * The cached value of the '{@link #getOwnedModeTransitions() <em>Owned Mode Transition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedModeTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<ModeTransition> ownedModeTransitions;

	/**
	 * The default value of the '{@link #isDerivedModes() <em>Derived Modes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDerivedModes()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DERIVED_MODES_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isDerivedModes() <em>Derived Modes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDerivedModes()
	 * @generated
	 * @ordered
	 */
	protected boolean derivedModes = DERIVED_MODES_EDEFAULT;
	/**
	 * The default value of the '{@link #isNoFlows() <em>No Flows</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoFlows()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NO_FLOWS_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isNoFlows() <em>No Flows</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoFlows()
	 * @generated
	 * @ordered
	 */
	protected boolean noFlows = NO_FLOWS_EDEFAULT;
	/**
	 * The default value of the '{@link #isNoModes() <em>No Modes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoModes()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NO_MODES_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isNoModes() <em>No Modes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoModes()
	 * @generated
	 * @ordered
	 */
	protected boolean noModes = NO_MODES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentClassifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getComponentClassifier();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassifierFeature> getClassifierFeatures() {
		return new DerivedUnionEObjectEList<ClassifierFeature>(ClassifierFeature.class, this,
				Aadl2Package.COMPONENT_CLASSIFIER__CLASSIFIER_FEATURE, CLASSIFIER_FEATURE_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getClassifierFeatures() <em>Classifier Feature</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassifierFeatures()
	 * @generated
	 * @ordered
	 */
	protected static final int[] CLASSIFIER_FEATURE_ESUBSETS = new int[] {
			Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE, Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE_TRANSITION };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedElement> getOwnedMembers() {
		return new DerivedUnionEObjectEList<NamedElement>(NamedElement.class, this,
				Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MEMBER, OWNED_MEMBER_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedMembers() <em>Owned Member</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMembers()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_MEMBER_ESUBSETS = new int[] {
			Aadl2Package.COMPONENT_CLASSIFIER__OWNED_ANNEX_SUBCLAUSE,
			Aadl2Package.COMPONENT_CLASSIFIER__OWNED_PROTOTYPE, Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE,
			Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE_TRANSITION };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mode> getOwnedModes() {
		if (ownedModes == null) {
			ownedModes = new EObjectContainmentEList<Mode>(Mode.class, this,
					Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE);
		}
		return ownedModes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mode createOwnedMode() {
		Mode newOwnedMode = (Mode) create(Aadl2Package.eINSTANCE.getMode());
		getOwnedModes().add(newOwnedMode);
		return newOwnedMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModeTransition> getOwnedModeTransitions() {
		if (ownedModeTransitions == null) {
			ownedModeTransitions = new EObjectContainmentEList<ModeTransition>(ModeTransition.class, this,
					Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE_TRANSITION);
		}
		return ownedModeTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModeTransition createOwnedModeTransition() {
		ModeTransition newOwnedModeTransition = (ModeTransition) create(Aadl2Package.eINSTANCE.getModeTransition());
		getOwnedModeTransitions().add(newOwnedModeTransition);
		return newOwnedModeTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDerivedModes() {
		return derivedModes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDerivedModes(boolean newDerivedModes) {
		boolean oldDerivedModes = derivedModes;
		derivedModes = newDerivedModes;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.COMPONENT_CLASSIFIER__DERIVED_MODES,
					oldDerivedModes, derivedModes));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNoFlows() {
		return noFlows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNoFlows(boolean newNoFlows) {
		boolean oldNoFlows = noFlows;
		noFlows = newNoFlows;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.COMPONENT_CLASSIFIER__NO_FLOWS,
					oldNoFlows, noFlows));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNoModes() {
		return noModes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNoModes(boolean newNoModes) {
		boolean oldNoModes = noModes;
		noModes = newNoModes;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.COMPONENT_CLASSIFIER__NO_MODES,
					oldNoModes, noModes));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE:
			return ((InternalEList<?>) getOwnedModes()).basicRemove(otherEnd, msgs);
		case Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE_TRANSITION:
			return ((InternalEList<?>) getOwnedModeTransitions()).basicRemove(otherEnd, msgs);
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
		case Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE:
			return getOwnedModes();
		case Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE_TRANSITION:
			return getOwnedModeTransitions();
		case Aadl2Package.COMPONENT_CLASSIFIER__DERIVED_MODES:
			return isDerivedModes();
		case Aadl2Package.COMPONENT_CLASSIFIER__NO_FLOWS:
			return isNoFlows();
		case Aadl2Package.COMPONENT_CLASSIFIER__NO_MODES:
			return isNoModes();
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
		case Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE:
			getOwnedModes().clear();
			getOwnedModes().addAll((Collection<? extends Mode>) newValue);
			return;
		case Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE_TRANSITION:
			getOwnedModeTransitions().clear();
			getOwnedModeTransitions().addAll((Collection<? extends ModeTransition>) newValue);
			return;
		case Aadl2Package.COMPONENT_CLASSIFIER__DERIVED_MODES:
			setDerivedModes((Boolean) newValue);
			return;
		case Aadl2Package.COMPONENT_CLASSIFIER__NO_FLOWS:
			setNoFlows((Boolean) newValue);
			return;
		case Aadl2Package.COMPONENT_CLASSIFIER__NO_MODES:
			setNoModes((Boolean) newValue);
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
		case Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE:
			getOwnedModes().clear();
			return;
		case Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE_TRANSITION:
			getOwnedModeTransitions().clear();
			return;
		case Aadl2Package.COMPONENT_CLASSIFIER__DERIVED_MODES:
			setDerivedModes(DERIVED_MODES_EDEFAULT);
			return;
		case Aadl2Package.COMPONENT_CLASSIFIER__NO_FLOWS:
			setNoFlows(NO_FLOWS_EDEFAULT);
			return;
		case Aadl2Package.COMPONENT_CLASSIFIER__NO_MODES:
			setNoModes(NO_MODES_EDEFAULT);
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
		case Aadl2Package.COMPONENT_CLASSIFIER__CLASSIFIER_FEATURE:
			return isSetClassifierFeatures();
		case Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MEMBER:
			return isSetOwnedMembers();
		case Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE:
			return ownedModes != null && !ownedModes.isEmpty();
		case Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE_TRANSITION:
			return ownedModeTransitions != null && !ownedModeTransitions.isEmpty();
		case Aadl2Package.COMPONENT_CLASSIFIER__DERIVED_MODES:
			return derivedModes != DERIVED_MODES_EDEFAULT;
		case Aadl2Package.COMPONENT_CLASSIFIER__NO_FLOWS:
			return noFlows != NO_FLOWS_EDEFAULT;
		case Aadl2Package.COMPONENT_CLASSIFIER__NO_MODES:
			return noModes != NO_MODES_EDEFAULT;
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
		result.append(" (derivedModes: ");
		result.append(derivedModes);
		result.append(", noFlows: ");
		result.append(noFlows);
		result.append(", noModes: ");
		result.append(noModes);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetClassifierFeatures() {
		return super.isSetClassifierFeatures() || eIsSet(Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE)
				|| eIsSet(Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE_TRANSITION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedMembers() {
		return super.isSetOwnedMembers() || eIsSet(Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE)
				|| eIsSet(Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE_TRANSITION);
	}
} // ComponentClassifierImpl
