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
import java.util.Iterator;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierFeature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.aadl2.operations.BehavioredImplementationOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behaviored Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.BehavioredImplementationImpl#getMembers <em>Member</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.BehavioredImplementationImpl#getClassifierFeatures <em>Classifier Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.BehavioredImplementationImpl#getOwnedMembers <em>Owned Member</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.BehavioredImplementationImpl#getSubprogramCalls <em>Subprogram Call</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.BehavioredImplementationImpl#getOwnedSubprogramCallSequences <em>Owned Subprogram Call Sequence</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class BehavioredImplementationImpl extends ComponentImplementationImpl
		implements BehavioredImplementation {
	/**
	 * The cached value of the '{@link #getOwnedSubprogramCallSequences() <em>Owned Subprogram Call Sequence</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSubprogramCallSequences()
	 * @generated
	 * @ordered
	 */
	protected EList<SubprogramCallSequence> ownedSubprogramCallSequences;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BehavioredImplementationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getBehavioredImplementation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedElement> getMembers() {
		return new DerivedUnionEObjectEList<NamedElement>(NamedElement.class, this,
				Aadl2Package.BEHAVIORED_IMPLEMENTATION__MEMBER, MEMBER_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getMembers() <em>Member</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMembers()
	 * @generated
	 * @ordered
	 */
	protected static final int[] MEMBER_ESUBSETS = new int[] { Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_MEMBER,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__CLASSIFIER_FEATURE,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__INHERITED_MEMBER,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__SUBPROGRAM_CALL };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassifierFeature> getClassifierFeatures() {
		return new DerivedUnionEObjectEList<ClassifierFeature>(ClassifierFeature.class, this,
				Aadl2Package.BEHAVIORED_IMPLEMENTATION__CLASSIFIER_FEATURE, CLASSIFIER_FEATURE_ESUBSETS);
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
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_MODE,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_MODE_TRANSITION,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_SUBCOMPONENT,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_FLOW_IMPLEMENTATION,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_CONNECTION,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_END_TO_END_FLOW,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_PROCESSOR_FEATURE,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_INTERNAL_FEATURE,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_SUBPROGRAM_CALL_SEQUENCE };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedElement> getOwnedMembers() {
		return new DerivedUnionEObjectEList<NamedElement>(NamedElement.class, this,
				Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_MEMBER, OWNED_MEMBER_ESUBSETS);
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
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_ANNEX_SUBCLAUSE,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_PROTOTYPE, Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_MODE,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_MODE_TRANSITION,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_SUBCOMPONENT,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_CONNECTION,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_END_TO_END_FLOW,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_PROCESSOR_FEATURE,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_INTERNAL_FEATURE,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_SUBPROGRAM_CALL_SEQUENCE };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<SubprogramCall> getSubprogramCalls() {
		// DONE: implement this method to return the 'Subprogram Call' reference list
		return BehavioredImplementationOperations.subprogramCalls(this);
	}

	public EList<SubprogramCallSequence> getAllSubprogramCallSequences() {
		EList<Classifier> ancestors = getSelfPlusAllExtended();
		final BasicEList<SubprogramCallSequence> returnlist = new BasicEList<SubprogramCallSequence>();
		for (Iterator<Classifier> it = ancestors.iterator(); it.hasNext();) {
			final BehavioredImplementation current = (BehavioredImplementation) it.next();
			returnlist.addAll(current.getOwnedSubprogramCallSequences());
		}
		return returnlist;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubprogramCallSequence> getOwnedSubprogramCallSequences() {
		if (ownedSubprogramCallSequences == null) {
			ownedSubprogramCallSequences = new EObjectContainmentEList<SubprogramCallSequence>(
					SubprogramCallSequence.class, this,
					Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_SUBPROGRAM_CALL_SEQUENCE);
		}
		return ownedSubprogramCallSequences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramCallSequence createOwnedSubprogramCallSequence() {
		SubprogramCallSequence newOwnedSubprogramCallSequence = (SubprogramCallSequence) create(
				Aadl2Package.eINSTANCE.getSubprogramCallSequence());
		getOwnedSubprogramCallSequences().add(newOwnedSubprogramCallSequence);
		return newOwnedSubprogramCallSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubprogramCall> subprogramCalls() {
		return BehavioredImplementationOperations.subprogramCalls(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_SUBPROGRAM_CALL_SEQUENCE:
			return ((InternalEList<?>) getOwnedSubprogramCallSequences()).basicRemove(otherEnd, msgs);
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
		case Aadl2Package.BEHAVIORED_IMPLEMENTATION__SUBPROGRAM_CALL:
			return getSubprogramCalls();
		case Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_SUBPROGRAM_CALL_SEQUENCE:
			return getOwnedSubprogramCallSequences();
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
		case Aadl2Package.BEHAVIORED_IMPLEMENTATION__SUBPROGRAM_CALL:
			getSubprogramCalls().clear();
			getSubprogramCalls().addAll((Collection<? extends SubprogramCall>) newValue);
			return;
		case Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_SUBPROGRAM_CALL_SEQUENCE:
			getOwnedSubprogramCallSequences().clear();
			getOwnedSubprogramCallSequences().addAll((Collection<? extends SubprogramCallSequence>) newValue);
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
		case Aadl2Package.BEHAVIORED_IMPLEMENTATION__SUBPROGRAM_CALL:
			getSubprogramCalls().clear();
			return;
		case Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_SUBPROGRAM_CALL_SEQUENCE:
			getOwnedSubprogramCallSequences().clear();
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
		case Aadl2Package.BEHAVIORED_IMPLEMENTATION__MEMBER:
			return isSetMembers();
		case Aadl2Package.BEHAVIORED_IMPLEMENTATION__CLASSIFIER_FEATURE:
			return isSetClassifierFeatures();
		case Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_MEMBER:
			return isSetOwnedMembers();
		case Aadl2Package.BEHAVIORED_IMPLEMENTATION__SUBPROGRAM_CALL:
			return !getSubprogramCalls().isEmpty();
		case Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_SUBPROGRAM_CALL_SEQUENCE:
			return ownedSubprogramCallSequences != null && !ownedSubprogramCallSequences.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMembers() {
		return super.isSetMembers() || eIsSet(Aadl2Package.BEHAVIORED_IMPLEMENTATION__SUBPROGRAM_CALL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetClassifierFeatures() {
		return super.isSetClassifierFeatures()
				|| eIsSet(Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_SUBPROGRAM_CALL_SEQUENCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedMembers() {
		return super.isSetOwnedMembers()
				|| eIsSet(Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_SUBPROGRAM_CALL_SEQUENCE);
	}

} // BehavioredImplementationImpl
